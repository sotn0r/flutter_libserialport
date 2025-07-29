package org.sigrok.flutter_libserialport

import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

class FlutterLibserialportPlugin: FlutterPlugin, MethodCallHandler {
    /// The MethodChannel that will the communication between Flutter and native Android
    private lateinit var channel : MethodChannel

    // This is the new entry point for the V2 embedding.
    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "flutter.sigrok.org/flutter_libserialport")
        channel.setMethodCallHandler(this)
    }

    

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        // The original method call handling logic remains the same.
        // It's likely just returning a "not implemented" or empty list
        // for Android, which is fine.
        if (call.method == "getAvailablePorts") {
            result.success(listOf<String>())
        } else {
            result.notImplemented()
        }
    }

    // This is the new exit point for the V2 embedding.
    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }
}