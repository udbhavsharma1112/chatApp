package com.chat.chatController;

public interface IMessage {
    public void showSenderMessage();
    public void showReceiverMessage();
    public String getSerializedContent();
    static public IMessage deserializeMessage(String mqttMessage) {
        return TextMessage.deserializeMessage(mqttMessage);
    }
}
