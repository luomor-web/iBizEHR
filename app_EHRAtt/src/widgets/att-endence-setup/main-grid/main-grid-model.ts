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
          dataType: 'TEXT',
        },
        {
          name: 'xbsj',
          prop: 'xbsj',
          dataType: 'TIME',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'allowoutwork',
          prop: 'allowoutwork',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'vacholidayrulesid',
          prop: 'vacholidayrulesid',
          dataType: 'PICKUP',
        },
        {
          name: 'sbsj',
          prop: 'sbsj',
          dataType: 'TIME',
        },
        {
          name: 'srfmajortext',
          prop: 'attendencesetupname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'attendencesetupid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'attendencesetupid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'dkfs',
          prop: 'dkfs',
          dataType: 'SSCODELIST',
        },
        {
          name: 'vacholidayrulesname',
          prop: 'vacholidayrulesname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'createman',
          prop: 'createman',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'attendencesetup',
          prop: 'attendencesetupid',
        },
      {
        name: 'n_ormorgname_like',
        prop: 'n_ormorgname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_attendencesetupname_like',
        prop: 'n_attendencesetupname_like',
        dataType: 'TEXT',
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