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
          name: 'fglx',
          prop: 'fglx',
          dataType: 'TEXT',
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
          name: 'srfmajortext',
          prop: 'ormdutyname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'ormdutyid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'ormdutyid',
          dataType: 'GUID',
        },
        {
          name: 'ormdutyname',
          prop: 'ormdutyname',
          dataType: 'TEXT',
        },
        {
          name: 'zwlb',
          prop: 'zwlb',
          dataType: 'SMCODELIST',
        },
        {
          name: 'ormduty',
          prop: 'ormdutyid',
        },
      {
        name: 'n_ormdutyname_like',
        prop: 'n_ormdutyname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_fglx_like',
        prop: 'n_fglx_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_zwlb_like',
        prop: 'n_zwlb_like',
        dataType: 'SMCODELIST',
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