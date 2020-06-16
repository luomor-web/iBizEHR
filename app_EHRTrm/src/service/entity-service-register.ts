/**
 * 实体数据服务注册中心
 *
 * @export
 * @class EntityServiceRegister
 */
export class EntityServiceRegister {

    /**
     * 所有实体数据服务Map
     *
     * @protected
     * @type {*}
     * @memberof EntityServiceRegister
     */
    protected allEntityService: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载实体数据服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof EntityServiceRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of EntityServiceRegister.
     * @memberof EntityServiceRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof EntityServiceRegister
     */
    protected init(): void {
                this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
        this.allEntityService.set('trmtrainfacies', () => import('@/service/trm-train-facies/trm-train-facies-service'));
        this.allEntityService.set('trmstaffnodes', () => import('@/service/trm-staffnodes/trm-staffnodes-service'));
        this.allEntityService.set('trmdutycadres', () => import('@/service/trm-duty-cadres/trm-duty-cadres-service'));
        this.allEntityService.set('trmlgbdetail', () => import('@/service/trm-lgb-detail/trm-lgb-detail-service'));
        this.allEntityService.set('attendancerecord', () => import('@/service/att-endance-record/att-endance-record-service'));
        this.allEntityService.set('trmtraffic', () => import('@/service/trm-traffic/trm-traffic-service'));
        this.allEntityService.set('trmtrainteacher', () => import('@/service/trm-train-teacher/trm-train-teacher-service'));
        this.allEntityService.set('trmplanformu', () => import('@/service/trm-plan-formu/trm-plan-formu-service'));
        this.allEntityService.set('trmstaff', () => import('@/service/trm-staff/trm-staff-service'));
        this.allEntityService.set('trmtraincourse', () => import('@/service/trm-train-course/trm-train-course-service'));
        this.allEntityService.set('trmtraindemandsum', () => import('@/service/trm-train-demand-sum/trm-train-demand-sum-service'));
        this.allEntityService.set('trmtrainresment', () => import('@/service/trm-train-resment/trm-train-resment-service'));
        this.allEntityService.set('trmtrainfillin', () => import('@/service/trm-train-fillin/trm-train-fillin-service'));
        this.allEntityService.set('trmgradecadres', () => import('@/service/trm-gradecadres/trm-gradecadres-service'));
        this.allEntityService.set('trmstay', () => import('@/service/trm-stay/trm-stay-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('trmtrainoutapply', () => import('@/service/trm-train-out-apply/trm-train-out-apply-service'));
        this.allEntityService.set('trmagencyrecord', () => import('@/service/trm-agency-record/trm-agency-record-service'));
        this.allEntityService.set('trmtrainperson', () => import('@/service/trm-train-person/trm-train-person-service'));
        this.allEntityService.set('trmlgbcost', () => import('@/service/trm-lgb-cost/trm-lgb-cost-service'));
        this.allEntityService.set('trmteachertrain', () => import('@/service/trm-teacher-train/trm-teacher-train-service'));
        this.allEntityService.set('trmtrainaddress', () => import('@/service/trm-train-address/trm-train-address-service'));
        this.allEntityService.set('trmtrainactapply', () => import('@/service/trm-train-actapply/trm-train-actapply-service'));
        this.allEntityService.set('trmtrainplanterm', () => import('@/service/trm-train-planterm/trm-train-planterm-service'));
        this.allEntityService.set('trmtraindemand', () => import('@/service/trm-train-demand/trm-train-demand-service'));
        this.allEntityService.set('trmtrainbuapply', () => import('@/service/trm-train-buapply/trm-train-buapply-service'));
        this.allEntityService.set('trmcouarrange', () => import('@/service/trm-couarrange/trm-couarrange-service'));
        this.allEntityService.set('trmcoursesystem', () => import('@/service/trm-course-system/trm-course-system-service'));
        this.allEntityService.set('dynachart', () => import('@/service/dyna-chart/dyna-chart-service'));
        this.allEntityService.set('trmemployeeretion', () => import('@/service/trm-employee-retion/trm-employee-retion-service'));
        this.allEntityService.set('trmtraindata', () => import('@/service/trm-train-data/trm-train-data-service'));
        this.allEntityService.set('trmzzobm', () => import('@/service/trm-zzobm/trm-zzobm-service'));
        this.allEntityService.set('trminvoice', () => import('@/service/trm-invoice/trm-invoice-service'));
        this.allEntityService.set('trmtrainactment', () => import('@/service/trm-train-actment/trm-train-actment-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/orm-orgsector/orm-orgsector-service'));
        this.allEntityService.set('ormbmkqdz', () => import('@/service/orm-bmkqdz/orm-bmkqdz-service'));
        this.allEntityService.set('trmteachercharge', () => import('@/service/trm-teacher-charge/trm-teacher-charge-service'));
        this.allEntityService.set('trmdepartneeds', () => import('@/service/trm-depart-needs/trm-depart-needs-service'));
        this.allEntityService.set('ormerporg', () => import('@/service/orm-erporg/orm-erporg-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pim-person/pim-person-service'));
        this.allEntityService.set('trmdemdeftion', () => import('@/service/trm-demdeftion/trm-demdeftion-service'));
        this.allEntityService.set('trmdepart', () => import('@/service/trm-depart/trm-depart-service'));
        this.allEntityService.set('trmtrainplan', () => import('@/service/trm-train-plan/trm-train-plan-service'));
        this.allEntityService.set('trmtrainagency', () => import('@/service/trm-train-agency/trm-train-agency-service'));
        this.allEntityService.set('trmhmatser', () => import('@/service/trm-hmatser/trm-hmatser-service'));
        this.allEntityService.set('dynadashboard', () => import('@/service/dyna-dashboard/dyna-dashboard-service'));
    }

    /**
     * 加载实体数据服务
     *
     * @protected
     * @param {string} serviceName
     * @returns {Promise<any>}
     * @memberof EntityServiceRegister
     */
    protected async loadService(serviceName: string): Promise<any> {
        const service = this.allEntityService.get(serviceName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取应用实体数据服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof EntityServiceRegister
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
export const entityServiceRegister: EntityServiceRegister = new EntityServiceRegister();