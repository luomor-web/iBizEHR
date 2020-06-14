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
          name: 'xh',
          prop: 'xh',
          dataType: 'INT',
        },
        {
          name: 'salsubjectname',
          prop: 'salsubjectname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'salsubjectid',
          prop: 'salsubjectid',
          dataType: 'PICKUP',
        },
        {
          name: 'updateman',
          prop: 'updateman',
          dataType: 'TEXT',
        },
        {
          name: 'salitemname',
          prop: 'salitemname',
          dataType: 'TEXT',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'srfmajortext',
          prop: 'salitemname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'salitemid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'salitemid',
          dataType: 'GUID',
        },
        {
          name: 'salitem',
          prop: 'salitemid',
        },
      {
        name: 'n_salitemname_like',
        prop: 'n_salitemname_like',
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