<template>
    <div :class="className">
        <div>
            <slot></slot>
        </div>
        <div :style=style>
            <slot name="propertypanel"></slot>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';

@Component({})
export default class PropertyLayout extends Vue {

    @Prop()
    public propertyType?: string;
    @Prop()
    public width?: string;
    @Prop()
    public height?: string;

    public className: string = '';

    public style: any;

    mounted(){
        let _className = 'top-and-bottom';
        let _style: any = {};
        _style.minWidth = this.width ? this.width + 'px' : '';
        _style.maxWidth = this.width ? this.width + 'px' : '';
        _style.minHeight = this.height ? this.height + 'px' : '';
        _style.maxHeight = this.height ? this.height + 'px' : '';
        if(Object.is(this.propertyType, 'RIGHT')) {
            _className = 'left-and-right';
        }
        this.style = _style;
        this.className = _className;
    }

}
</script>

<style lang='less'>
@import './property-layout.less';
</style>