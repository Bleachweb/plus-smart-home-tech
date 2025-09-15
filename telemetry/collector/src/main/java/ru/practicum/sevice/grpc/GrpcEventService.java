package ru.practicum.sevice.grpc;

import ru.practicum.grpc.telemetry.event.HubEventProto;
import ru.practicum.grpc.telemetry.event.SensorEventProto;


public interface GrpcEventService {
    void processSensorEvent(SensorEventProto sensorEventProto);
    void processHubEvent(HubEventProto hubEventProto);
}