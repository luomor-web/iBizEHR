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
          name: 'dd',
          prop: 'dd',
          dataType: 'TEXT',
        },
        {
          name: 'yysb',
          prop: 'yysb',
          dataType: 'SMCODELIST',
        },
        {
          name: 'bgsb',
          prop: 'bgsb',
          dataType: 'SMCODELIST',
        },
        {
          name: 'sb',
          prop: 'sb',
          dataType: 'SMCODELIST',
        },
        {
          name: 'dgsb',
          prop: 'dgsb',
          dataType: 'SMCODELIST',
        },
        {
          name: 'trmtrainaddressid',
          prop: 'trmtrainaddressid',
          dataType: 'PICKUP',
        },
        {
          name: 'sssl',
          prop: 'sssl',
          dataType: 'INT',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrainfaciesname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainfaciesid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainfaciesid',
          dataType: 'GUID',
        },
        {
          name: 'sslb',
          prop: 'sslb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmtrainfacies',
          prop: 'trmtrainfaciesid',
        },
      {
        name: 'n_trmtrainfaciesname_like',
        prop: 'n_trmtrainfaciesname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_sslb_eq',
        prop: 'n_sslb_eq',
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