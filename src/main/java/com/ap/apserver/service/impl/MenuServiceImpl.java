package com.ap.apserver.service.impl;

import com.ap.apserver.entity.Menu;
import com.ap.apserver.mapper.MenuMapper;
import com.ap.apserver.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuMapper mapper;

    @Override
    public List<Menu> queryFoodMenu() {
        return mapper.selectAll();
    }
}
