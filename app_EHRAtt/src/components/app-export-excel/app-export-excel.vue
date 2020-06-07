<template>
    <dropdown v-if="itemLevel === 0" :transfer="true" trigger='click'>
        <i-button :disabled="item.disabled">
            <i class='fa fa-file-excel-o'></i>
            <span class='caption'>{{caption}}</span>
        </i-button>
        <dropdown-menu slot='list'>
            <dropdown-item>
                <p @click="exportExcel($event, 'maxRowCount')">
                    {{caption}}{{$t('components.appExportExcel.total')}}({{$t('components.appExportExcel.max')}}{{caption}}{{item.MaxRowCount}}{{$t('components.appExportExcel.row')}})
                </p>
            </dropdown-item>
            <dropdown-item>
                <p @click="exportExcel($event, 'activatedPage')">
                    {{caption}}{{$t('components.appExportExcel.currentPage')}}
                </p>
            </dropdown-item>
        </dropdown-menu>
    </dropdown>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';

/**
 * 数据导出组件
 *
 * @export
 * @class AppExportExcel
 * @extends {Vue}
 */
@Component({
})
export default class AppExportExcel extends Vue {

    /**
     * 工具栏项
     *
     * @type {*}
     * @memberof AppExportExcel
     */
    @Prop() public item?: any;

    /**
     * 工具栏项
     *
     * @type {*}
     * @memberof AppExportExcel
     */
    @Prop() public caption?: any;

    /**
     * 工具栏项层级
     *
     * @type {number}
     * @memberof AppExportExcel
     */
    @Prop({ default: 0 }) public itemLevel!: number;

    /**
     * 起始页
     *
     * @type {(string | null)}
     * @memberof AppExportExcel
     */
    public startPage: string | null = null;

    /**
     * 结束页
     *
     * @type {(string | null)}
     * @memberof AppExportExcel
     */
    public endPage: string | null = null;

    /**
     * 是否显示下拉菜单
     *
     * @type {boolean}
     * @memberof AppExportExcel
     */
    public visible: boolean = false;

    /**
     * 点击触发相似
     *
     * @memberof AppExportExcel
     */
    public clickVisible(): void {
        this.visible = !this.visible
    }

    /**
     * 导出数据
     *
     * @param {*} $event
     * @param {string} type
     * @returns {void}
     * @memberof AppExportExcel
     */
    public exportExcel($event: any, type: string): void {
        const exportparms: any = { type: type };
        if (Object.is(type, 'maxRowCount')) {
            Object.assign(exportparms, { maxRowCount: this.item.MaxRowCount })
            this.visible = false;
        } else if (Object.is(type, 'activatedPage')) {
            this.visible = false;
        } else if (Object.is(type, 'custom')) {
            if (!this.startPage || !this.endPage) {
                this.$Notice.warning({ title: '警告', desc: '请输入起始页' });
                return;
            }
            const startPage: any = Number.parseInt(this.startPage, 10);
            const endPage: any = Number.parseInt(this.endPage, 10);
            if (Number.isNaN(startPage) || Number.isNaN(endPage)) {
                this.$Notice.warning({ title: '警告', desc: '请输入有效的起始页' });
                return;
            }

            if (startPage < 1 || endPage < 1 || startPage > endPage) {
                this.$Notice.warning({ title: '警告', desc: '请输入有效的起始页' });
                return;
            }
            this.startPage = null;
            this.endPage = null;
            Object.assign(exportparms, { startPage: startPage, endPage: endPage });
            this.visible = false;
        }
        if (!this.visible) {
            Object.assign($event, { exportparms: exportparms });
            this.$emit('exportexcel', $event);
        }
    }

}
</script>

<style lang='less'>
@import './app-export-excel.less';
</style>
