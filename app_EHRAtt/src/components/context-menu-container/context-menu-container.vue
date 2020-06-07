<template>
    <div class='context-menu-container' ref='container'>
        <slot></slot>
    </div>
</template>

<script lang="ts">
class ContextMenuContainerService {
    // 是否屏蔽浏览器右键单机
    public __isShielding = false;

    constructor() {
        document.oncontextmenu = () => {
            return !this.__isShielding;
        };
    }

    public enableShielding() {
        this.__isShielding = true;
    }

    public notEnableShielding() {
        this.__isShielding = false;
    }
}

const service = new ContextMenuContainerService();

import { Vue, Component, Provide } from 'vue-property-decorator';

// tslint:disable-next-line:max-classes-per-file
@Component({})
export default class ContextMenuContainer extends Vue {
    @Provide()
    public isShielding: boolean = false;

    public mounted() {
        const container: any = this.$refs.container;
        // 鼠标移入
        container.onmouseover = () => {
            service.enableShielding();
        };
        // 鼠标移出
        container.onmouseout = () => {
            service.notEnableShielding();
        };
    }

}
</script>

<style lang='less'>

</style>
