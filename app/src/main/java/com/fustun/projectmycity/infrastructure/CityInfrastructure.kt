package com.fustun.projectmycity.infrastructure

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fustun.projectmycity.R
import com.fustun.projectmycity.ui.theme.CityViewModel
import com.fustun.projectmycity.ui.theme.ProjectMyCityTheme

class CityInfrastructure {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CityTopBar(currTopBarTitle : Int, topBarCanNavigateUp : Boolean, navigateUp :()->Unit, modifier: Modifier = Modifier){
        CenterAlignedTopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription =null,
                        modifier = modifier.size(dimensionResource(id = R.dimen.paddingLargest))
                    )
                    Spacer(modifier = modifier.width(dimensionResource(id = R.dimen.paddingSmallest)))
                    Text(text = stringResource(id = currTopBarTitle))
                }
            },
            navigationIcon = {
                if (topBarCanNavigateUp){
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.back_button)
                        )
                    }
                }
            }
        )
    }


    @Composable
    fun CityCancelButton(onCancelButtonClicked : () -> Unit , modifier: Modifier = Modifier){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.paddingMedium)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            OutlinedButton(onClick = onCancelButtonClicked ) {
                Text(stringResource(R.string.cancel).uppercase())
            }
        }
    }

    @Composable
    fun cityNavigation() : NavHostController{
        return rememberNavController()
    }

    @Composable
    fun cityViewModel() : CityViewModel{
        return viewModel()
    }
}

