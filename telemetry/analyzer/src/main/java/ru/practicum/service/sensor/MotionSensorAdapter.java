package ru.practicum.service.sensor;

import ru.yandex.practicum.kafka.telemetry.event.MotionSensorAvro;

import java.util.Optional;

public class MotionSensorAdapter implements SensorDataAdapter {
    private final MotionSensorAvro motionSensor;

    public MotionSensorAdapter(MotionSensorAvro motionSensor) {
        this.motionSensor = motionSensor;
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
        return Optional.of(motionSensor.getMotion());
    }

    @Override
    public Optional<Boolean> getSwitchState() {
        return Optional.empty();
    }
}