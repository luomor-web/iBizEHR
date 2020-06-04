import { Http,Util } from '@/utils';
import PimArchivesCenterServiceBase from './pim-archives-center-service-base';


/**
 * 档案室管理服务对象
 *
 * @export
 * @class PimArchivesCenterService
 * @extends {PimArchivesCenterServiceBase}
 */
export default class PimArchivesCenterService extends PimArchivesCenterServiceBase {

    /**
     * Creates an instance of  PimArchivesCenterService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimArchivesCenterService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}