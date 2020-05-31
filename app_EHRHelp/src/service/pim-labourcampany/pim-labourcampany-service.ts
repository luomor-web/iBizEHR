import { Http,Util } from '@/utils';
import PimLabourcampanyServiceBase from './pim-labourcampany-service-base';


/**
 * 劳务派遣公司管理服务对象
 *
 * @export
 * @class PimLabourcampanyService
 * @extends {PimLabourcampanyServiceBase}
 */
export default class PimLabourcampanyService extends PimLabourcampanyServiceBase {

    /**
     * Creates an instance of  PimLabourcampanyService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimLabourcampanyService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}