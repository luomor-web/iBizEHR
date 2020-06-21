/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'trmtrainaddressid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtrainaddressname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'trmtrainaddressname',
        prop: 'trmtrainaddressname',
        dataType: 'TEXT',
      },
      {
        name: 'sf',
        prop: 'sf',
        dataType: 'SSCODELIST',
      },
      {
        name: 's',
        prop: 's',
        dataType: 'TEXT',
      },
      {
        name: 'dz',
        prop: 'dz',
        dataType: 'TEXT',
      },
      {
        name: 'lxr',
        prop: 'lxr',
        dataType: 'TEXT',
      },
      {
        name: 'lxdh',
        prop: 'lxdh',
        dataType: 'TEXT',
      },
      {
        name: 'email',
        prop: 'email',
        dataType: 'TEXT',
      },
      {
        name: 'xz',
        prop: 'xz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'xj',
        prop: 'xj',
        dataType: 'TEXT',
      },
      {
        name: 'hjzk',
        prop: 'hjzk',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pxlx',
        prop: 'pxlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sfqy',
        prop: 'sfqy',
        dataType: 'YESNO',
      },
      {
        name: 'js',
        prop: 'js',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'gxfw',
        prop: 'gxfw',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrainaddressid',
        prop: 'trmtrainaddressid',
        dataType: 'GUID',
      },
      {
        name: 'trmtrainaddress',
        prop: 'trmtrainaddressid',
        dataType: 'FONTKEY',
      },
    ]
  }

}