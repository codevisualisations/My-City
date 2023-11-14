package com.fustun.projectmycity.infrastructure

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fustun.projectmycity.R
import com.fustun.projectmycity.data.CityCategories
import com.fustun.projectmycity.models.CityModels
import com.fustun.projectmycity.myCity.CityScreens
import com.fustun.projectmycity.ui.theme.CityViewModel
import com.fustun.projectmycity.ui.theme.ProjectMyCityTheme


class CityCards {
    @Composable
    fun <T : CityModels> CityOrAttractionCard(cat: T, modifier: Modifier = Modifier, onClick: () -> Unit) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onClick() }
        ) {
            Row(
                modifier = modifier.padding(dimensionResource(id = R.dimen.paddingSmall)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = cat.image),
                    modifier = modifier
                        .weight(1f)
                        .clip(CircleShape),
                    contentDescription = null
                )
                Text(
                    modifier = modifier
                        .weight(1.75f),
                    text = stringResource(id = cat.name),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }

    @Composable
    fun <T : CityModels> AttractionCard(cat: T, modifier: Modifier = Modifier) {
        if (cat is CityModels.Attractions) {
            Column(
                modifier = modifier
                    .padding(dimensionResource(id = R.dimen.paddingLarge))
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Image(
                    painter = painterResource(id = cat.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
                Spacer(modifier = modifier.padding(top = dimensionResource(id = R.dimen.paddingLarge)))
                Text(
                    text = stringResource(id = cat.description),
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }

    @Composable
    fun MyCityLogoCard(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.new_app_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.paddingSmall)))
            Text(
                text = "My City!",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }

    @Composable
    fun CityAndAttractionCard(
        uiState : CityViewModel,
        navController : NavController,
        topBarTitle : Int,
        cardList : List<CityModels>,
        card : CityModels.Attractions,
        topBarCanNavigateBack:Boolean,
        modifier: Modifier=Modifier)
    {
        val isCityRecommendations = cardList.firstOrNull() is CityModels.Cities
        Column{
            Row(
                modifier = Modifier.weight(0.9f)
                .fillMaxWidth()
            ){
                LazyColumn(
                    modifier = modifier
                        .weight(2f)
                        .padding(dimensionResource(id = R.dimen.paddingMedium)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.paddingSmall))
                ) {
                    items(cardList) { item ->
                        when (item) {
                            is CityModels.Continent -> {
                                CityCards().CityOrAttractionCard(
                                    cat = item,
                                    onClick = {
                                        uiState.updateRecommendationsList(title = item.name)
                                        uiState.updateTopBarTitle(title = item.name)
                                        uiState.updateExpandedAttractionCard(title = item.name)
                                        navController.navigate(CityScreens.RECOMMENDATIONS.name)
                                    }
                                )
                            }
                            is CityModels.Cities -> {
                                CityCards().CityOrAttractionCard(
                                    cat = item,
                                    onClick = {
                                        uiState.updateCurrentAttraction(title = item.name)
                                        uiState.updatePreviousTopBarTitle(title = topBarTitle)
                                        uiState.updateTopBarTitle(title = item.name)
                                        uiState.updateExpandedAttractionCard(title = item.name)
                                    }
                                )
                            }
                            else -> {}
                        }
                    }
                }
                Spacer(modifier = modifier.padding(dimensionResource(id = R.dimen.paddingSmall)))
                if (isCityRecommendations && card.name != R.string.app_name){
                    Column(modifier = modifier.weight(3f)){
                        AttractionCard(
                            cat = card)
                    }
                }else{
                    Column(modifier = modifier.weight(2f)){
                        MyCityLogoCard()
                    }
                }
        }
            if (topBarCanNavigateBack){
                CityInfrastructure().CityCancelButton(
                    modifier = Modifier
                        .weight(0.1f)
                        .fillMaxWidth(),
                    onCancelButtonClicked = {navController.popBackStack(CityScreens.ROOT.name,inclusive = false)},
                )
        }
        }
    }
}



//@Preview(device = Devices.TABLET)
//@Composable
//fun ContinentAndAttractionCardPreview(){
//    ProjectMyCityTheme(darkTheme = true){
//        val cardList = CityCategories.getCityRecommendationsNewDelhi()
//        val card = CityCategories.getCityAttraction(R.string.lotusTemple)
//        CityCards().CityAndAttractionCard(cardList = cardList, card = card)
//    }
//}