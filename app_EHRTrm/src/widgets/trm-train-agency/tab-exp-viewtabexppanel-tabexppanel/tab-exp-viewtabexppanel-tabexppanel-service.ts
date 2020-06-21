import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import TrmTrainAgencyService from '@/service/trm-train-agency/trm-train-agency-service';
import TabExpViewtabexppanelModel from './tab-exp-viewtabexppanel-tabexppanel-model';


/**
 * TabExpViewtabexppanel 部件服务对象
 *
 * @export
 * @class TabExpViewtabexppanelService
 */
export default class TabExpViewtabexppanelService extends ControlService {

    /**
     * 培训机构服务对象
     *
     * @type {TrmTrainAgencyService}
     * @memberof TabExpViewtabexppanelService
     */
    public appEntityService: TrmTrainAgencyService = new TrmTrainAgencyService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof TabExpViewtabexppanelService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of TabExpViewtabexppanelService.
     * 
     * @param {*} [opts={}]
     * @memberof TabExpViewtabexppanelService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new TabExpViewtabexppanelModel();
    }

    
}