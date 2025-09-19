package ru.practicum.service.sensor;

import java.util.Optional;

public interface SensorDataAdapter {
    Optional<Integer> getTemperature();
    Optional<Integer> getHumidity();
    Optional<Integer> getCo2Level();
    Optional<Integer> getLuminosity();
    Optional<Boolean> getMotion();
    Optional<Boolean> getSwitchState();
}