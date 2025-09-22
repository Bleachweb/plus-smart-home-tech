package ru.practicum.service.sensor;

import ru.yandex.practicum.kafka.telemetry.event.TemperatureSensorAvro;

import java.util.Optional;

public class TemperatureSensorAdapter implements SensorDataAdapter {
    private final TemperatureSensorAvro temperatureSensor;

    public TemperatureSensorAdapter(TemperatureSensorAvro temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    @Override
    public Optional<Integer> getTemperature() {
        return Optional.of(temperatureSensor.getTemperatureC());
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
        return Optional.empty();
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