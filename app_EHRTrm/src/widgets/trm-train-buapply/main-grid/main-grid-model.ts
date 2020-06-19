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
          name: 'trmtrainplantermname',
          prop: 'trmtrainplantermname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'qtfy',
          prop: 'qtfy',
          dataType: 'FLOAT',
        },
        {
          name: 'trmtrainplantermid',
          prop: 'trmtrainplantermid',
          dataType: 'PICKUP',
        },
        {
          name: 'cdzj',
          prop: 'cdzj',
          dataType: 'FLOAT',
        },
        {
          name: 'jflx',
          prop: 'jflx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrainbuapplyname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainbuapplyid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainbuapplyid',
          dataType: 'GUID',
        },
        {
          name: 'jgfy',
          prop: 'jgfy',
          dataType: 'FLOAT',
        },
        {
          name: 'szf',
          prop: 'szf',
          dataType: 'FLOAT',
        },
        {
          name: 'tzysxm',
          prop: 'tzysxm',
          dataType: 'TEXT',
        },
        {
          name: 'clf',
          prop: 'clf',
          dataType: 'FLOAT',
        },
        {
          name: 'tzje',
          prop: 'tzje',
          dataType: 'FLOAT',
        },
        {
          name: 'trmtrainbuapply',
          prop: 'trmtrainbuapplyid',
        },
      {
        name: 'n_trmtrainplantermname_like',
        prop: 'n_trmtrainplantermname_like',
        dataType: 'PICKUPTEXT',
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