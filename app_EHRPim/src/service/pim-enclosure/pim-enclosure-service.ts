import { Http,Util } from '@/utils';
import PimEnclosureServiceBase from './pim-enclosure-service-base';


/**
 * 附件信息服务对象
 *
 * @export
 * @class PimEnclosureService
 * @extends {PimEnclosureServiceBase}
 */
export default class PimEnclosureService extends PimEnclosureServiceBase {

    /**
     * Creates an instance of  PimEnclosureService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimEnclosureService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}