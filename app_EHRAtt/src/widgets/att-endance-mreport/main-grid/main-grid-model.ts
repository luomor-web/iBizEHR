/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'attendencesetupname',
          prop: 'attendencesetupname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'yf',
          prop: 'yf',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'updateman',
          prop: 'updateman',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'attendancemreportname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'attendancemreportid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'attendancemreportid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'orgid',
          prop: 'orgid',
          dataType: 'TEXT',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zt',
          prop: 'zt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'attendencesetupid',
          prop: 'attendencesetupid',
          dataType: 'PICKUP',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'attendancemreport',
          prop: 'attendancemreportid',
        },
      {
        name: 'n_nd_eq',
        prop: 'n_nd_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_yf_eq',
        prop: 'n_yf_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zt_eq',
        prop: 'n_zt_eq',
        dataType: 'SSCODELIST',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}