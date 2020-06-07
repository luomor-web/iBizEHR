import { FormDetailModel } from './form-detail';
import { FormTabPanelModel } from './form-tab-panel';

/**
 * 分页面板模型
 *
 * @export
 * @class FormTabPageModel
 * @extends {FormDetailModel}
 */
export class FormTabPageModel extends FormDetailModel {


    /**
     * Creates an instance of FormTabPageModel.
     * FormTabPageModel 实例
     * 
     * @param {*} [opts={}]
     * @memberof FormTabPageModel
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 设置分页是否启用
     *
     * @param {boolean} state
     * @memberof FormTabPageModel
     */
    public setVisible(state: boolean): void {
        this.visible = state;
        const tabPanel = this.getTabPanelModel();
        if (tabPanel) {
            tabPanel.setActiviePage();
        }
    }

    /**
     * 获取分页面板
     *
     * @returns {(FormTabPanelModel | null)}
     * @memberof FormTabPageModel
     */
    public getTabPanelModel(): FormTabPanelModel | null {
        if (!this.form) {
            return null;
        }
        const tabPanels: any[] = Object.values(this.form.detailsModel).filter((model: any) => Object.is(model.detailType, 'TABPANEL'));
        let index = tabPanels.findIndex((tabPanel: any) => {
            return tabPanel.tabPages.some((tabPag: any) => Object.is(tabPag.name, this.name));
        });
        if (index === -1) {
            return null;
        }
        const tabPanel: FormTabPanelModel = tabPanels[index];
        return tabPanel;
    }
}