import { Http,Util } from '@/utils';
import PimVocationalServiceBase from './pim-vocational-service-base';


/**
 * 证书信息服务对象
 *
 * @export
 * @class PimVocationalService
 * @extends {PimVocationalServiceBase}
 */
export default class PimVocationalService extends PimVocationalServiceBase {

    /**
     * Creates an instance of  PimVocationalService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimVocationalService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}