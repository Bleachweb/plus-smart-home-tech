package ru.practicum.service.sensor;

import ru.yandex.practicum.kafka.telemetry.event.ClimateSensorAvro;
import ru.yandex.practicum.kafka.telemetry.event.LightSensorAvro;
import ru.yandex.practicum.kafka.telemetry.event.MotionSensorAvro;
import ru.yandex.practicum.kafka.telemetry.event.SwitchSensorAvro;
import ru.yandex.practicum.kafka.telemetry.event.TemperatureSensorAvro;

public class SensorDataAdapterFactory {

    public static SensorDataAdapter getAdapter(Object sensorData) {
        if (sensorData instanceof ClimateSensorAvro) {
            return new ClimateSensorAdapter((ClimateSensorAvro) sensorData);
        } else if (sensorData instanceof LightSensorAvro) {
            return new LightSensorAdapter((LightSensorAvro) sensorData);
        } else if (sensorData instanceof MotionSensorAvro) {
            return new MotionSensorAdapter((MotionSensorAvro) sensorData);
        } else if (sensorData instanceof SwitchSensorAvro) {
            return new SwitchSensorAdapter((SwitchSensorAvro) sensorData);
        } else if (sensorData instanceof TemperatureSensorAvro) {
            return new TemperatureSensorAdapter((TemperatureSensorAvro) sensorData);
        } else {
            throw new IllegalArgumentException("Unsupported sensor data type: " + sensorData.getClass());
        }
    }
}