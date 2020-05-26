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
          name: 'nationarea',
          prop: 'nationarea',
          dataType: 'TEXT',
        },
        {
          name: 'xh',
          prop: 'xh',
          dataType: 'INT',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xxxz',
          prop: 'xxxz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pcmgxmlname',
          prop: 'pcmgxmlname',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmgxmlname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmgxmlid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmgxmlid',
          dataType: 'GUID',
        },
        {
          name: 'xxxz_text',
          prop: 'xxxz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pcmgxml',
          prop: 'pcmgxmlid',
        },
      {
        name: 'n_nationarea_like',
        prop: 'n_nationarea_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_xxxz_eq',
        prop: 'n_xxxz_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pcmgxmlname_like',
        prop: 'n_pcmgxmlname_like',
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