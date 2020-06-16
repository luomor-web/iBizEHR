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
          name: 'jglx',
          prop: 'jglx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'sfgx',
          prop: 'sfgx',
          dataType: 'YESNO',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainagencyname2',
          prop: 'trmtrainagencyname2',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmtrainagencyname',
          prop: 'trmtrainagencyname',
          dataType: 'TEXT',
        },
        {
          name: 'zcxx',
          prop: 'zcxx',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrainagencyname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainagencyid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainagencyid',
          dataType: 'GUID',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'jglb',
          prop: 'jglb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'lxdh',
          prop: 'lxdh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'trmtrainagencyid2',
          prop: 'trmtrainagencyid2',
          dataType: 'PICKUP',
        },
        {
          name: 'jgdj',
          prop: 'jgdj',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmtrainagency',
          prop: 'trmtrainagencyid',
        },
      {
        name: 'n_trmtrainagencyname_like',
        prop: 'n_trmtrainagencyname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_jgdj_eq',
        prop: 'n_jgdj_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_sfgx_eq',
        prop: 'n_sfgx_eq',
        dataType: 'YESNO',
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