<template>
    <div class="app-range-editor">
        <template v-for="(item, index) in refFormItem">
            <span v-if="index > 0" class="editor-space"  :key="index+10">~</span>
            <date-picker 
             :key="index"
              v-if="Object.is(editorType, 'DATEPICKEREX') || Object.is(editorType, 'DATEPICKEREX_NOTIME')" 
              type="date" 
              :transfer="true"
              :format="valFormat"
              :placeholder="$t('components.appRangeEditor.placeholder')"
              :value="activeData[item]"
              :disabled="disabled" 
              @on-change="(value,type)=>{onValueChange(item,value)}">
            </date-picker>
            <time-picker
              :key="index"
              v-else-if="editorType.startsWith('DATEPICKEREX')"
              :transfer="true"
              :format="valFormat"
              :placeholder="$t('components.appRangeEditor.placeholder')"
              :value="activeData[item]"
              :disabled="disabled"
              @on-change="(value)=>{onValueChange(item,value)}">
            </time-picker>
            <InputNumber
              :key="index"
              v-else-if="Object.is(editorType, 'NUMBER')"
              :value="activeData[item]" 
              :disabled="disabled"
              :placeholder="$t('components.appRangeEditor.input')"
              @on-change="(value)=>{onValueChange(item,value)}">
            </InputNumber>
            <app-span
              :key="index"
              v-else-if="Object.is(editorType, 'SPAN')"
              :value="activeData[item]"
              :disabled="disabled">
            </app-span>
            <el-input
              :key="index"
              v-else
              :value="getValue(item)" 
              :disabled="disabled"
              :placeholder="$t('components.appRangeEditor.input')"
              @input="(value)=>{onValueChange(item,value)}">
            </el-input>
        </template>
    </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Model, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';

@Component({
})
export default class AppRangeEditor extends Vue {

    /**
     * 编辑项名称
     *
     * @type {string}
     * @memberof AppRangeEditor
     */
    @Prop() public name!: string;

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof AppRangeEditor
     */
    @Prop() public disabled!: boolean;

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof AppRangeEditor
     */
    @Prop() public activeData: any;

    /**
     * 值格式
     *
     * @type {string}
     * @memberof AppRangeEditor
     */
    @Prop() public format!: string;

    /**
     * 编辑器类型
     *
     * @type {string}
     * @memberof AppRangeEditor
     */
    @Prop() public editorType!: string;

    /**
     * 关系表单项集合
     *
     * @type {string[]}
     * @memberof AppRangeEditor
     */
    @Prop() public refFormItem!: string[];

    /**
     * 值变化时间
     *
     * @private
     * @type {Subject<any>}
     * @memberof InputBox
     */
    private inputDataChang: Subject<any> = new Subject()

    /**
     * 处理值格式
     *
     * @readonly
     * @memberof AppRangeEditor
     */
    get valFormat() {
        return this.format.replace('YYYY', 'yyyy').replace('DD', 'dd');
    }

    /**
     * 获取值
     *
     * @param {string} name
     * @returns
     * @memberof AppRangeEditor
     */
    public getValue(name: string) {
        return this.activeData[name];
    }

    /**
     * 设置值
     *
     * @param {string} name
     * @param {*} val
     * @memberof AppRangeEditor
     */
    public setValue(name: string, val: any) {
        this.inputDataChang.next({ name: name, value: val });
    }

    /**
     * vue  声明周期 debounceTime
     *
     * @memberof InputBox
     */
    public created() {
        this.inputDataChang
            .pipe(
                debounceTime(500),
                distinctUntilChanged()
            ).subscribe((data: any) => {
                this.$emit('formitemvaluechange', { name: data.name, value: data.value });
            });
    }

    /**
     * 值改变
     *
     * @param {string} name
     * @param {*} value
     * @memberof AppRangeEditor
     */
    public onValueChange(name: string, value: any) {
        this.$emit('formitemvaluechange', { name: name, value: value });
    }

}
</script>

<style lang='less'>
@import './app-range-editor.less';
</style>