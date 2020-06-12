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
        prop: 'salstdgwgzid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'salstdgwgzname',
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
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormdutyname',
        prop: 'ormdutyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'dj',
        prop: 'dj',
        dataType: 'SSCODELIST',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'FLOAT',
      },
      {
        name: 'jbgzbl',
        prop: 'jbgzbl',
        dataType: 'FLOAT',
      },
      {
        name: 'jxgzbl',
        prop: 'jxgzbl',
        dataType: 'FLOAT',
      },
      {
        name: 'ormdutyid',
        prop: 'ormdutyid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'salstdgwgzid',
        prop: 'salstdgwgzid',
        dataType: 'GUID',
      },
      {
        name: 'salstdgwgz',
        prop: 'salstdgwgzid',
        dataType: 'FONTKEY',
      },
    ]
  }

}