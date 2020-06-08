import { Http,Util } from '@/utils';
import PcmNoRecyclingLibraryServiceBase from './pcm-no-recycling-library-service-base';


/**
 * 员工编号回收库服务对象
 *
 * @export
 * @class PcmNoRecyclingLibraryService
 * @extends {PcmNoRecyclingLibraryServiceBase}
 */
export default class PcmNoRecyclingLibraryService extends PcmNoRecyclingLibraryServiceBase {

    /**
     * Creates an instance of  PcmNoRecyclingLibraryService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmNoRecyclingLibraryService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}