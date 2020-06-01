/**
 * YGSZKQ 部件模型
 *
 * @export
 * @class YGSZKQModel
 */
export default class YGSZKQModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof YGSZKQGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof YGSZKQGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ygzt',
          prop: 'ygzt',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'attendencesetupid',
          prop: 'attendencesetupid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'attendancesettingsname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'attendancesettingsid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'attendancesettingsid',
          dataType: 'GUID',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'attendancesettingsid',
          prop: 'attendancesettingsid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'attendancesettings',
          prop: 'attendancesettingsid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_zzdzs_like',
        prop: 'n_zzdzs_like',
        dataType: 'PICKUPDATA',
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