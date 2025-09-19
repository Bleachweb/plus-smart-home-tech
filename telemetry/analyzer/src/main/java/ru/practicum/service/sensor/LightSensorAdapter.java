package ru.practicum.service.sensor;

import ru.yandex.practicum.kafka.telemetry.event.LightSensorAvro;

import java.util.Optional;

public class LightSensorAdapter implements SensorDataAdapter {
    private final LightSensorAvro lightSensor;

    public LightSensorAdapter(LightSensorAvro lightSensor) {
        this.lightSensor = lightSensor;
    }

    @Override
    public Optional<Integer> getTemperature() {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getHumidity() {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getCo2Level() {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getLuminosity() {
        return Optional.of(lightSensor.getLuminosity());
    }

    @Override
    public Optional<Boolean> getMotion() {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> getSwitchState() {
        return Optional.empty();
    }
}