import { Http,Util } from '@/utils';
import TRMINVOICEServiceBase from './trminvoice-service-base';


/**
 * 开票信息服务对象
 *
 * @export
 * @class TRMINVOICEService
 * @extends {TRMINVOICEServiceBase}
 */
export default class TRMINVOICEService extends TRMINVOICEServiceBase {

    /**
     * Creates an instance of  TRMINVOICEService.
     * 
     * @param {*} [opts={}]
     * @memberof  TRMINVOICEService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}