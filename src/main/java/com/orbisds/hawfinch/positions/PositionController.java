package com.orbisds.hawfinch.positions;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @RequestMapping("/positions/{id}")
    public Position getPosition(@PathVariable String id) {
        return positionService.getPosition(id);
    }

    @RequestMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/positions")
    public void addPosition(@RequestBody Position position) {
        positionService.addPosition(position);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/positions/{id}")
    public void updatePosition(@RequestBody Position position, @PathVariable String id) {
        positionService.updatePosition(id, position);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/positions/{id}")
    public void deletePosition(@PathVariable String id) {
        positionService.deletePosition(id);
    }
    

}
