package com.uwsoft.editor.renderer.systems.action.logic;

import com.badlogic.ashley.core.Entity;
import com.uwsoft.editor.renderer.components.ActionComponent;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.systems.action.data.MoveToData;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

/**
 * Created by Eduard on 10/13/2015.
 */
public class MoveToAction extends TemporalAction {
    @Override
    public void update(float percent, Entity entity) {
        TransformComponent transformComponent = ComponentRetriever.get(entity, TransformComponent.class);
        ActionComponent<MoveToData> actionComponent = ComponentRetriever.get(entity, ActionComponent.class);

        float x = actionComponent.data.startX + (actionComponent.data.endX - actionComponent.data.startX) * percent;
        float y = actionComponent.data.startY + (actionComponent.data.endY - actionComponent.data.startY) * percent;

        transformComponent.x = x;
        transformComponent.y = y;
    }

    @Override
    public void begin(Entity entity) {
        TransformComponent transformComponent = ComponentRetriever.get(entity, TransformComponent.class);
        ActionComponent<MoveToData> actionComponent = ComponentRetriever.get(entity, ActionComponent.class);
        actionComponent.data.startX = transformComponent.x;
        actionComponent.data.startY = transformComponent.y;
    }

    @Override
    public void end(Entity entity) {

    }
}
