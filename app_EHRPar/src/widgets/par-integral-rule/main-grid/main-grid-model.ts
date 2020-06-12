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
          name: 'integrals',
          prop: 'integrals',
          dataType: 'INT',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'dj',
          prop: 'dj',
          dataType: 'SSCODELIST',
        },
        {
          name: 'updateman',
          prop: 'updateman',
          dataType: 'TEXT',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'parintegralrulename',
          prop: 'parintegralrulename',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'parintegralrulename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'parintegralruleid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'parintegralruleid',
          dataType: 'GUID',
        },
        {
          name: 'parintegralrule',
          prop: 'parintegralruleid',
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