import { Http,Util } from '@/utils';
import PimPaperServiceBase from './pim-paper-service-base';


/**
 * 论文信息服务对象
 *
 * @export
 * @class PimPaperService
 * @extends {PimPaperServiceBase}
 */
export default class PimPaperService extends PimPaperServiceBase {

    /**
     * Creates an instance of  PimPaperService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimPaperService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}