package ru.practicum.service.sensor;

import ru.yandex.practicum.kafka.telemetry.event.ClimateSensorAvro;

import java.util.Optional;

public class ClimateSensorAdapter implements SensorDataAdapter {
    private final ClimateSensorAvro climateSensor;

    public ClimateSensorAdapter(ClimateSensorAvro climateSensor) {
        this.climateSensor = climateSensor;
    }

    @Override
    public Optional<Integer> getTemperature() {
        return Optional.of(climateSensor.getTemperatureC());
    }

    @Override
    public Optional<Integer> getHumidity() {
        return Optional.of(climateSensor.getHumidity());
    }

    @Override
    public Optional<Integer> getCo2Level() {
        return Optional.of(climateSensor.getCo2Level());
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