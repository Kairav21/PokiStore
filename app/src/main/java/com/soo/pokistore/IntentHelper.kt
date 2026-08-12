package com.soo.pokistore

import android.content.Context
import android.content.Intent
import android.os.Bundle


fun openIntent(context: Context, order: String, activityToOpen : Class<*>)
{
    //declare intent with contet and class to pass value
    val intent = Intent(context, activityToOpen)
    //pass through the string value with key "ordder"
    intent.putExtra("order", order)
    //if the context is not an activity
    if (context !is android.app.Activity)
    {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    //start activity
    context.startActivity(intent)
    }
fun shareIntent(context: Context, order: String)
{
    val sendIntent = Intent()
    //setting the action to tell it what to do
    sendIntent.setAction(Intent.ACTION_SEND)
    sendIntent.putExtra(Intent.EXTRA_TEXT, order)
    //we are sending plain text
    sendIntent.setType("text/plain")
    //show the share intent
    val shareIntent = Intent.createChooser(sendIntent, null)

    //if the context is not an activity
    if (context !is android.app.Activity)
    {
        sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }

    context.startActivity(shareIntent)
}

fun shareIntent(context : Context, order : Order)
{
    val sendIntent = Intent()
    sendIntent.setAction(Intent.ACTION_SEND)

    //create bundle to store/add multiple values
    val shareOrderDetails = Bundle()
    shareOrderDetails.putString("productName", order.productName)
    shareOrderDetails.putString("customerName", order.customerName)
    shareOrderDetails.putString("customerCell", order.customerCell)

    //share the entire bundle
    sendIntent.putExtra(Intent.EXTRA_TEXT, shareOrderDetails)
    sendIntent.setType("text/plain")

    val shareIntent = Intent.createChooser(sendIntent, null)

    //if the context is not an activity
    if (context !is android.app.Activity)
    {
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }

    context.startActivity(shareIntent)
}