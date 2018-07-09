package cn.crap.adapter;

import cn.crap.dto.ModuleDto;
import cn.crap.model.Module;
import cn.crap.model.Project;
import cn.crap.utils.BeanUtil;
import cn.crap.utils.DateFormartUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Automatic generation by tools
 * model adapter: convert model to dto
 * Avoid exposing sensitive data and modifying data that is not allowed to be modified
 */
public class ModuleAdapter {
    public static ModuleDto getDto(Module model, Project project){
        if (model == null){
            return null;
        }

        ModuleDto dto = new ModuleDto();
        BeanUtil.copyProperties(model, dto);

        if (model.getCreateTime() != null) {
            dto.setCreateTimeStr(DateFormartUtil.getDateByTimeMillis(model.getCreateTime().getTime()));
        }
		if (project != null) {
            dto.setProjectName(project.getName());
        }
		
        return dto;
    }

    public static Module getModel(ModuleDto dto){
        if (dto == null){
            return null;
        }
        Module model = new Module();
        model.setId(dto.getId());
		model.setName(dto.getName());
		model.setSequence(dto.getSequence());
		model.setUrl(dto.getUrl());
		model.setRemark(dto.getRemark());
		model.setCategory(dto.getCategory());
		
        return model;
    }

    public static List<ModuleDto> getDto(List<Module> models, Project project){
        if (CollectionUtils.isEmpty(models)){
            return new ArrayList<>();
        }
        List<ModuleDto> dtos = new ArrayList<>();
        for (Module model : models){
            dtos.add(getDto(model, project));
        }
        return dtos;
    }
}
