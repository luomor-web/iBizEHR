import { Http,Util } from '@/utils';
import WFWorkListServiceBase from './wfwork-list-service-base';


/**
 * 工作流工作列表服务对象
 *
 * @export
 * @class WFWorkListService
 * @extends {WFWorkListServiceBase}
 */
export default class WFWorkListService extends WFWorkListServiceBase {

    /**
     * Creates an instance of  WFWorkListService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFWorkListService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}