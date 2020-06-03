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
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'vacholidayrulesname',
          prop: 'vacholidayrulesname',
          dataType: 'TEXT',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'updateman',
          prop: 'updateman',
          dataType: 'TEXT',
        },
        {
          name: 'sfqy',
          prop: 'sfqy',
          dataType: 'SSCODELIST',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'srfmajortext',
          prop: 'vacholidayrulesname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'vacholidayrulesid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'vacholidayrulesid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'vacholidayrules',
          prop: 'vacholidayrulesid',
        },
      {
        name: 'n_ormorgname_like',
        prop: 'n_ormorgname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_nd_eq',
        prop: 'n_nd_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_vacholidayrulesname_like',
        prop: 'n_vacholidayrulesname_like',
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