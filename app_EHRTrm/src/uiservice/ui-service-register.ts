/**
 * UI服务注册中心
 *
 * @export
 * @class UIServiceRegister
 */
export class UIServiceRegister {

    /**
     * 所有UI实体服务Map
     *
     * @protected
     * @type {*}
     * @memberof UIServiceRegister
     */
    protected allUIService: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载UI实体服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof UIServiceRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of UIServiceRegister.
     * @memberof UIServiceRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UIServiceRegister
     */
    protected init(): void {
                this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('trmtrainfacies', () => import('@/uiservice/trm-train-facies/trm-train-facies-ui-service'));
        this.allUIService.set('trmstaffnodes', () => import('@/uiservice/trm-staffnodes/trm-staffnodes-ui-service'));
        this.allUIService.set('trmdutycadres', () => import('@/uiservice/trm-duty-cadres/trm-duty-cadres-ui-service'));
        this.allUIService.set('trmlgbdetail', () => import('@/uiservice/trm-lgb-detail/trm-lgb-detail-ui-service'));
        this.allUIService.set('attendancerecord', () => import('@/uiservice/att-endance-record/att-endance-record-ui-service'));
        this.allUIService.set('trmtraffic', () => import('@/uiservice/trm-traffic/trm-traffic-ui-service'));
        this.allUIService.set('trmtrainteacher', () => import('@/uiservice/trm-train-teacher/trm-train-teacher-ui-service'));
        this.allUIService.set('trmplanformu', () => import('@/uiservice/trm-plan-formu/trm-plan-formu-ui-service'));
        this.allUIService.set('trmstaff', () => import('@/uiservice/trm-staff/trm-staff-ui-service'));
        this.allUIService.set('trmtraincourse', () => import('@/uiservice/trm-train-course/trm-train-course-ui-service'));
        this.allUIService.set('trmtraindemandsum', () => import('@/uiservice/trm-train-demand-sum/trm-train-demand-sum-ui-service'));
        this.allUIService.set('trmtrainresment', () => import('@/uiservice/trm-train-resment/trm-train-resment-ui-service'));
        this.allUIService.set('trmtrainfillin', () => import('@/uiservice/trm-train-fillin/trm-train-fillin-ui-service'));
        this.allUIService.set('trmgradecadres', () => import('@/uiservice/trm-gradecadres/trm-gradecadres-ui-service'));
        this.allUIService.set('trmstay', () => import('@/uiservice/trm-stay/trm-stay-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/orm-org/orm-org-ui-service'));
        this.allUIService.set('trmtrainoutapply', () => import('@/uiservice/trm-train-out-apply/trm-train-out-apply-ui-service'));
        this.allUIService.set('trmagencyrecord', () => import('@/uiservice/trm-agency-record/trm-agency-record-ui-service'));
        this.allUIService.set('trmtrainperson', () => import('@/uiservice/trm-train-person/trm-train-person-ui-service'));
        this.allUIService.set('trmlgbcost', () => import('@/uiservice/trm-lgb-cost/trm-lgb-cost-ui-service'));
        this.allUIService.set('trmteachertrain', () => import('@/uiservice/trm-teacher-train/trm-teacher-train-ui-service'));
        this.allUIService.set('trmtrainaddress', () => import('@/uiservice/trm-train-address/trm-train-address-ui-service'));
        this.allUIService.set('trmtrainactapply', () => import('@/uiservice/trm-train-actapply/trm-train-actapply-ui-service'));
        this.allUIService.set('trmtrainplanterm', () => import('@/uiservice/trm-train-planterm/trm-train-planterm-ui-service'));
        this.allUIService.set('trmtraindemand', () => import('@/uiservice/trm-train-demand/trm-train-demand-ui-service'));
        this.allUIService.set('trmtrainbuapply', () => import('@/uiservice/trm-train-buapply/trm-train-buapply-ui-service'));
        this.allUIService.set('trmcouarrange', () => import('@/uiservice/trm-couarrange/trm-couarrange-ui-service'));
        this.allUIService.set('trmcoursesystem', () => import('@/uiservice/trm-course-system/trm-course-system-ui-service'));
        this.allUIService.set('dynachart', () => import('@/uiservice/dyna-chart/dyna-chart-ui-service'));
        this.allUIService.set('trmemployeeretion', () => import('@/uiservice/trm-employee-retion/trm-employee-retion-ui-service'));
        this.allUIService.set('trmtraindata', () => import('@/uiservice/trm-train-data/trm-train-data-ui-service'));
        this.allUIService.set('trmzzobm', () => import('@/uiservice/trm-zzobm/trm-zzobm-ui-service'));
        this.allUIService.set('trminvoice', () => import('@/uiservice/trm-invoice/trm-invoice-ui-service'));
        this.allUIService.set('trmtrainactment', () => import('@/uiservice/trm-train-actment/trm-train-actment-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/orm-orgsector/orm-orgsector-ui-service'));
        this.allUIService.set('ormbmkqdz', () => import('@/uiservice/orm-bmkqdz/orm-bmkqdz-ui-service'));
        this.allUIService.set('trmteachercharge', () => import('@/uiservice/trm-teacher-charge/trm-teacher-charge-ui-service'));
        this.allUIService.set('trmdepartneeds', () => import('@/uiservice/trm-depart-needs/trm-depart-needs-ui-service'));
        this.allUIService.set('ormerporg', () => import('@/uiservice/orm-erporg/orm-erporg-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pim-person/pim-person-ui-service'));
        this.allUIService.set('trmdemdeftion', () => import('@/uiservice/trm-demdeftion/trm-demdeftion-ui-service'));
        this.allUIService.set('trmdepart', () => import('@/uiservice/trm-depart/trm-depart-ui-service'));
        this.allUIService.set('trmtrainplan', () => import('@/uiservice/trm-train-plan/trm-train-plan-ui-service'));
        this.allUIService.set('trmtrainagency', () => import('@/uiservice/trm-train-agency/trm-train-agency-ui-service'));
        this.allUIService.set('trmhmatser', () => import('@/uiservice/trm-hmatser/trm-hmatser-ui-service'));
        this.allUIService.set('dynadashboard', () => import('@/uiservice/dyna-dashboard/dyna-dashboard-ui-service'));
    }

    /**
     * 加载服务实体
     *
     * @protected
     * @param {string} serviceName
     * @returns {Promise<any>}
     * @memberof UIServiceRegister
     */
    protected async loadService(serviceName: string): Promise<any> {
        const service = this.allUIService.get(serviceName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取应用实体服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof UIServiceRegister
     */
    public async getService(name: string): Promise<any> {
        if (this.serviceCache.has(name)) {
            return this.serviceCache.get(name);
        }
        const entityService: any = await this.loadService(name);
        if (entityService && entityService.default) {
            const instance: any = new entityService.default();
            this.serviceCache.set(name, instance);
            return instance;
        }
    }

}
export const uiServiceRegister: UIServiceRegister = new UIServiceRegister();