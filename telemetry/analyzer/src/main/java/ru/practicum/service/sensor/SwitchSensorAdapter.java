package ru.practicum.service.sensor;

import ru.yandex.practicum.kafka.telemetry.event.SwitchSensorAvro;

import java.util.Optional;

public class SwitchSensorAdapter implements SensorDataAdapter {
    private final SwitchSensorAvro switchSensor;

    public SwitchSensorAdapter(SwitchSensorAvro switchSensor) {
        this.switchSensor = switchSensor;
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
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> getMotion() {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> getSwitchState() {
        return Optional.of(switchSensor.getState());
    }
}