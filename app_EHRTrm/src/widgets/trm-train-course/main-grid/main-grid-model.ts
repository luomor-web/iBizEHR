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
          name: 'trmcoursesystemid',
          prop: 'trmcoursesystemid',
          dataType: 'PICKUP',
        },
        {
          name: 'nr',
          prop: 'nr',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'sfgx',
          prop: 'sfgx',
          dataType: 'YESNO',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pxmb',
          prop: 'pxmb',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtraincoursename',
          dataType: 'TEXT',
        },
        {
          name: 'trmtraincoursename',
          prop: 'trmtraincoursename',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'trmtraincourseid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtraincourseid',
          dataType: 'GUID',
        },
        {
          name: 'kcxs',
          prop: 'kcxs',
          dataType: 'FLOAT',
        },
        {
          name: 'jb',
          prop: 'jb',
          dataType: 'TEXT',
        },
        {
          name: 'trmtrainagencyid',
          prop: 'trmtrainagencyid',
          dataType: 'PICKUP',
        },
        {
          name: 'bb',
          prop: 'bb',
          dataType: 'TEXT',
        },
        {
          name: 'trmcoursesystemname',
          prop: 'trmcoursesystemname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmtraincourse',
          prop: 'trmtraincourseid',
        },
      {
        name: 'n_trmtraincoursename_like',
        prop: 'n_trmtraincoursename_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_kclb_eq',
        prop: 'n_kclb_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_skfs_eq',
        prop: 'n_skfs_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_trmtrainagencyname_eq',
        prop: 'n_trmtrainagencyname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgname_eq',
        prop: 'n_ormorgname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgid_eq',
        prop: 'n_ormorgid_eq',
      },
      {
        name: 'n_trmtrainagencyid_eq',
        prop: 'n_trmtrainagencyid_eq',
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