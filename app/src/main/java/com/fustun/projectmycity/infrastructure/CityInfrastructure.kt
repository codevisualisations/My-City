package com.fustun.projectmycity.infrastructure

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fustun.projectmycity.R
import com.fustun.projectmycity.ui.theme.CityViewModel

class CityInfrastructure {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CityTopBar(currTopBarTitle : Int, modifier: Modifier = Modifier){
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
            }
        )
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
