import { Http,Util } from '@/utils';
import WFVersionServiceBase from './wfversion-service-base';


/**
 * 工作流配置版本***服务对象
 *
 * @export
 * @class WFVersionService
 * @extends {WFVersionServiceBase}
 */
export default class WFVersionService extends WFVersionServiceBase {

    /**
     * Creates an instance of  WFVersionService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFVersionService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}