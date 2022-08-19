package com.orbisds.hawfinch.positions;

import com.orbisds.hawfinch.lang.Lang;
import com.orbisds.hawfinch.lang.LangRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PositionService {


    private final PositionRepository positionRepository;


    public Position getPosition(String id) {
        return positionRepository.findById(id).orElse(null);
    }

    public List<Position> getAllPositions() {
        List<Position> positions = new ArrayList<>();
        positionRepository.findAll().forEach(positions::add);
        return positions;
    }

    public void addPosition(Position position) {
        positionRepository.save(position);
    }

    public void updatePosition(String id, Position position) {
        positionRepository.save(position);
    }

    public void deletePosition(String id) {
        positionRepository.deleteById(id);
    }


}
