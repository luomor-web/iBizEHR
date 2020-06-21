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
          name: 'zfy',
          prop: 'zfy',
          dataType: 'FLOAT',
        },
        {
          name: 'trmtrainteachername',
          prop: 'trmtrainteachername',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmtrainplantermname',
          prop: 'trmtrainplantermname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmtrainteacherid',
          prop: 'trmtrainteacherid',
          dataType: 'PICKUP',
        },
        {
          name: 'dj',
          prop: 'dj',
          dataType: 'FLOAT',
        },
        {
          name: 'xs',
          prop: 'xs',
          dataType: 'FLOAT',
        },
        {
          name: 'trmtrainplantermid',
          prop: 'trmtrainplantermid',
          dataType: 'PICKUP',
        },
        {
          name: 'jsdj',
          prop: 'jsdj',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'trmteacherchargename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmteacherchargeid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmteacherchargeid',
          dataType: 'GUID',
        },
        {
          name: 'trmteachercharge',
          prop: 'trmteacherchargeid',
        },
      {
        name: 'n_jsdj_eq',
        prop: 'n_jsdj_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_trmtrainplantermname_eq',
        prop: 'n_trmtrainplantermname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_trmtrainplantermname_like',
        prop: 'n_trmtrainplantermname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_trmtrainplantermid_eq',
        prop: 'n_trmtrainplantermid_eq',
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