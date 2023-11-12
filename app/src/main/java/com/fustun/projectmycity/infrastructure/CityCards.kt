package com.fustun.projectmycity.infrastructure

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.fustun.projectmycity.R
import com.fustun.projectmycity.models.CityModels


class CityCards {
    @Composable
    fun <T : CityModels> ContinentOrCityCard(cat: T, modifier: Modifier = Modifier, onClick: () -> Unit) {
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
    fun <T : CityModels> CityCityCard(cat : T, modifier: Modifier=Modifier){
        if (cat is CityModels.Attractions){
            Card{
                Image(
                    painter = painterResource(id = cat.image),
                    contentDescription = null)
            }
            Text(
                text = stringResource(id = cat.description),
                modifier = modifier.verticalScroll(rememberScrollState()).padding(dimensionResource(id = R.dimen.paddingMedium))
            )
        }
    }
}
