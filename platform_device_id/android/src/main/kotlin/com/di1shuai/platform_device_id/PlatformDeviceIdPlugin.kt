package com.di1shuai.platform_device_id

import androidx.annotation.NonNull;


import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler

/** Plugin method host for presenting a share sheet via Intent  */
class PlatformDeviceIdPlugin : FlutterPlugin, ActivityAware,MethodCallHandler {
  private lateinit var methodChannel: MethodChannel

  override fun onAttachedToEngine(binding: FlutterPluginBinding) {
    methodChannel = MethodChannel(binding.binaryMessenger, CHANNEL)
    methodChannel.setMethodCallHandler(this)
  }

  override fun onDetachedFromEngine(binding: FlutterPluginBinding) {
    methodChannel.setMethodCallHandler(null)
  }

  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
  }

  override fun onDetachedFromActivity() {
  }

  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    onAttachedToActivity(binding)
  }

  override fun onDetachedFromActivityForConfigChanges() {
    onDetachedFromActivity()
  }

  companion object {
    private const val CHANNEL = "platform_device_id"
  }

  override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    } else {
      result.notImplemented()
    }
  }
}