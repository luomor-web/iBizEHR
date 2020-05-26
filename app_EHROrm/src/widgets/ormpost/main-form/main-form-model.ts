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
        prop: 'ormpostid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'ormpostname',
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
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'gwtype',
        prop: 'gwtype',
        dataType: 'SMCODELIST',
      },
      {
        name: 'ormpostname',
        prop: 'ormpostname',
        dataType: 'TEXT',
      },
      {
        name: 'nx',
        prop: 'nx',
        dataType: 'INT',
      },
      {
        name: 'bxjlnx',
        prop: 'bxjlnx',
        dataType: 'INT',
      },
      {
        name: 'isconfidential',
        prop: 'isconfidential',
        dataType: 'SSCODELIST',
      },
      {
        name: 'postnature',
        prop: 'postnature',
        dataType: 'SSCODELIST',
      },
      {
        name: 'iskeypostion',
        prop: 'iskeypostion',
        dataType: 'SSCODELIST',
      },
      {
        name: 'startstopsign',
        prop: 'startstopsign',
        dataType: 'SSCODELIST',
      },
      {
        name: 'gwfl',
        prop: 'gwfl',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ormpostid',
        prop: 'ormpostid',
        dataType: 'GUID',
      },
      {
        name: 'ormpost',
        prop: 'ormpostid',
        dataType: 'FONTKEY',
      },
    ]
  }

}