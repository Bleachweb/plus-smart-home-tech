package ru.practicum.sevice.grpc.handler.sensor;

import ru.practicum.grpc.telemetry.event.SensorEventProto;

public interface SensorEventGrpcHandler {
    SensorEventProto.PayloadCase getMessageType();
    void handle(SensorEventProto event);
}